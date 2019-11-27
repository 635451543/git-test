app.service('payService',function ($http) {
    this.createNative=function () {
        return $http.get('payServlet');
    }
});