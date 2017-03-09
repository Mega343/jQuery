// выполняем код после полной загрузки
function setMenu(menuItem) {
    $('li').removeClass('active');
    $(menuItem).addClass('active');
}
$(function () {

    _.templateSettings = {
        interpolate: /\<\@\=(.+?)\@\>/gim,
        evaluate: /\<\@(.+?)\@\>/gim,
        escape: /\<\@\-(.+?)\@\>/gim
    };

    var UserModel  = Backbone.Model.extend({
        url: function() {
            return "rest/user/" + (this.id ? this.id : '');
        }
    });

    var UsersCollection = Backbone.Collection.extend({
        model: UserModel,
        url: "rest/user/users"
    });

    var users = new UsersCollection();

    var UsersView = Backbone.View.extend({
        el: $('.content'),
        template: _.template($('#users').html()),
        initialize: function () {
            this.render();
        },
        render: function () {
            setMenu('.users');
            users.fetch({async: false});
            var models = {"users": users.toJSON()};
            this.$el.html(this.template(models));
        }
    });
    var AddUserView = Backbone.View.extend({
        el: $('.content'),
        events: {
            'click #addSbmt': 'submitForm'
        },
        template: _.template($('#addUser').html()),
        initialize: function () {
            this.render();
        },
        render: function () {
            setMenu('.addUser');
            this.$el.html(this.template({}));
        },
        submitForm: function() {
            var user = new UserModel();
            user.set('firstName', $('#firstName').val());
            user.set('lastName', $('#lastName').val());
            user.set('email', $('#email').val());
            user.set('phoneNumber', $('#phoneNumber').val());
            user.set('password', $('#password').val());
            user.set('confirmPassword', $('#confirmPassword').val());
            user.save({async: false});
            window.location.hash = 'users';
        }
    });
    var EditUserView = Backbone.View.extend({
        el: $('.content'),
        events: {
            'click #updateSbmt': 'submitForm'
        },
        template: _.template($('#editUser').html()),
        initialize: function (options) {
            this.user = new UserModel();
            this.user.set('id', options.id);
            this.user.fetch({async: false});
            this.render();
        },
        render: function () {
            var model = {"user": this.user.toJSON()};
            this.$el.html(this.template(model));
        },
        submitForm: function() {
            var user = new UserModel();
            user.set('userID', $('#userID').val());
            user.set('id', $('#userID').val());
            user.set('firstName', $('#firstName').val());
            user.set('lastName', $('#lastName').val());
            user.set('email', $('#email').val());
            user.set('password', $('#password').val());
            user.set('confirmPassword', $('#confirmPassword').val());
            user.set('phoneNumber', $('#phoneNumber').val());
            user.set('cityName', $('#cityName').val());
            user.set('streetName', $('#streetName').val());
            user.set('houseNumber', $('#houseNumber').val());
            user.set('flatNumber', $('#flatNumber').val());
            user.set('addressID', $('#addressID').val());
            user.set('documentID', $('#documentID').val());
            user.set('documentType', $('#documentType').val());
            user.set('series', $('#series').val());
            user.set('number', $('#number').val());
            user.set('issuedBy', $('#issuedBy').val());
            user.set('dateOfIssue', $('#dateOfIssue').val());
            user.set('karma', $('#karma').val());
            user.set('userRole', $('#userRole').val());

            user.save({async: false});
            window.location.hash = 'users';
        }
    });

    var MainRouter = Backbone.Router.extend({
        routes: {
            "": "users",
            "users": "users",
            "addUser": "addUser",
            "editUser/:id": "editUser",
            "deleteUser/:id": "deleteUser"
        },
        initialize: function () {
            Backbone.history.start();
        },
        users: function () {
            new UsersView();
        },
        addUser: function () {
            new AddUserView();
        },
        editUser: function (id) {
            new EditUserView({id: id});
        },
        deleteUser: function(id) {
            var user = new UserModel;
            user.set('id', id);
            user.destroy({async: false});
            user.destroy({
                success: function () {

                },
                error: function (model, error) {
                    alert("alertError: " + error.responseText);
                }
            });
            window.location.hash = 'users';
        }
    });

    var mainRouter = new MainRouter();

});