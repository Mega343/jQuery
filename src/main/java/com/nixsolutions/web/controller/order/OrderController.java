package com.nixsolutions.web.controller.order;

import com.nixsolutions.model.Book;
import com.nixsolutions.model.Order;
import com.nixsolutions.model.User;
import com.nixsolutions.dto.OrderDTO;
import com.nixsolutions.service.BookService;
import com.nixsolutions.service.OrderService;
import com.nixsolutions.service.OrderTypeService;
import com.nixsolutions.service.UserService;
import com.nixsolutions.util.OrderReturnDateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderTypeService orderTypeService;

    private Book book;
    private List<Order> orders;

    @RequestMapping(value = "/add_order", method = RequestMethod.GET)
    public ModelAndView addOrderForm(Model model) {
        org.springframework.security.core.userdetails.User loggedUser = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.searchByEmail(loggedUser.getUsername());
        OrderDTO order = new OrderDTO(bookService.getAllBooks(), orderTypeService.getAllOrderTypes(), userService.getAllUsers(), user.getFirstName() + " " + user.getLastName());
        order.setLibrarianID(user.getUserID());
        return new ModelAndView("addOrder", "order", order);
    }
    @RequestMapping(value = "/add_order", method = RequestMethod.POST)
    public String addOrder(@ModelAttribute("order") OrderDTO order, Model model) {
        book = bookService.getBook(order.getBookID());
        if (book.getBookInWarehouse() > 0) {
            Order newOrder = new Order();
            newOrder.setBook(bookService.getBook(order.getBookID()));
            newOrder.setLibrarian(userService.getUser(order.getLibrarianID()));
            newOrder.setUser(userService.getUser(order.getUserID()));
            newOrder.setOrderType(orderTypeService.getOrderType(order.getOrderTypeID()));
            newOrder.setExpectedReturnDate(new Date(new OrderReturnDateUtil().setExpectedReturnDate(order.getOrderTypeID())));
            orderService.add(newOrder);
            book.setBookInWarehouse(book.getBookInWarehouse() - 1);
            bookService.edit(book);
            return "redirect:/orders";
        } else {
            model.addAttribute("error", "Sorry, cannot create order. In warehouse no book.");
            return "redirect:/orders";
        }
    }

    @RequestMapping(value = "/close", method = RequestMethod.GET)
    public String closeOrder(@RequestParam("order_id") String orderID) {
        Order order = orderService.getOrder(Long.parseLong(orderID));
        order.setActualReturnDate(new Date(System.currentTimeMillis()));
        orderService.edit(order);
        book = bookService.getBook(order.getBook().getBookID());
        book.setBookInWarehouse(book.getBookInWarehouse() + 1);
        bookService.edit(book);
        return "redirect:/orders";
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public String viewOrderForm(Model model) {
        orders = orderService.getAllOrders();
        if (orders.isEmpty()) {
            model.addAttribute("error", "Table orders is empty.");
            return "orders";
        } else {
            model.addAttribute("orders", orders);
            return "orders";
        }
    }


}
