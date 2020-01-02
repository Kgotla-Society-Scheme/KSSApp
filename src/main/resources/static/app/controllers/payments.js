angular.module('KSSApp')

// Creating the Angular Controller

    .controller('paymentsController', function($http, $scope, AuthService) {



        var edit = false;

        $scope.buttonText = 'Submit';

        var init = function() {

            $http.get('api/payments').success(function(res) {

                $scope.payments = res;

                $scope.userForm.$setPristine();

                $scope.message='';

                $scope.payment = null;

                $scope.buttonText = 'Submit';



            }).error(function(error) {

                $scope.message = error.message;

            });

        };

        $scope.initEdit = function(payment) {

            edit = true;

            $scope.payment = payment;

            $scope.message='';

            $scope.buttonText = 'Update';

        };

        $scope.initAddPayment = function() {

            edit = false;

            $scope.payment = null;

            $scope.userForm.$setPristine();

            $scope.message='';

            $scope.buttonText = 'Create';

        };

        $scope.deletePayment = function(payment) {

            $http.delete('api/payments/'+payment.id).success(function(res) {

                $scope.deleteMessage ="Success!";

                init();

            }).error(function(error) {

                $scope.deleteMessage = error.message;

            });

        };

        var editPayment = function(){

            $http.put('api/payments', $scope.payment).success(function(res) {

                $scope.payment = null;

               // $scope.confirmPassword = null;

                $scope.userForm.$setPristine();

                $scope.message = "Editting Success";

                init();

            }).error(function(error) {

                $scope.message =error.message;

            });

        };

        var addPayment = function(){

            $http.post('api/payments', $scope.payment).success(function(res) {

                $scope.payment = null;

               // $scope.confirmPassword = null;

                $scope.userForm.$setPristine();

                $scope.message = "User Created";

                init();

            }).error(function(error) {

                $scope.message = error.message;

            });

        };

        $scope.submit = function() {

            if(edit){

                editPayment();

            }else{

                addPayment();

            }

        };

        init();



    });

