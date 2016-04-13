/**
 * Created by Dendelion on 2016-04-13.
 */
(function () {
    "use strict";

    angular
        .module("firstApp")
        .controller("registerCtrl", function ($scope, $http) {
            $scope.user = {
                name: "",
                surname: "",
                passwd: "",
                email: "",
                repasswd: ""
            };

            $scope.message = {
                text: "you should not pass"
            }

            $scope.registerFun = function () {
                //console.info($scope.user);

                if ($scope.user.passwd === $scope.user.repasswd) {
                    console.info($scope.user);
                    $scope.message.text = 'ok';
                    var ajax = $http.post("/register/addUser", $scope.user);
                    ajax.success(function (data) {
                        $scope.message.text = ' user added ';
                    })
                } else {
                    console.error("pass and repass ");
                    $scope.message.text = 'fail';
                }
            }
        });
})();
