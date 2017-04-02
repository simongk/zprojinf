/**
 * Created by Szymon on 2017-04-02.
 */
(function(){
    'use strict';

    angular.module('event').controller('EventController', EventController);

    EventController.$inject = ['$http'];

    function EventController($http) {
        var controller = this;
        controller.events = [];
        controller.event = {id:null,name:'',location:'',date:''};
        controller.getAll = getAll;
        controller.submit = submit;

        init();

        function init() {
            getAll();
        }

        function getAll() {
            var url = "http://localhost:8080/event/all";
            var events = $http.get(url);

            events.then(function (response) {
                controller.events = response.data;
            });
        }

        function addEvent(newEvent){
            var url = "http://localhost:8080/event/add";
            var req = $http.post(url,newEvent);
            req.then(function (response) {
                controller.events = response.data;
                getAll();
            });
        }

        function submit(){
            addEvent(controller.event);
        }

    }
})();