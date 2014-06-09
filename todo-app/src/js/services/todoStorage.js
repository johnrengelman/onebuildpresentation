/*global angular */

/**
 * Services that persists and retrieves TODOs from localStorage
 */
(function() {
  angular.module('todomvc')
    .factory('todoStorage', ['$http', function ($http) {
      'use strict';

      var STORAGE_ID = 'todos-angularjs';

      return {
        get: function (getCallback) {
          $http.get('list').success(function(data) {
            getCallback(data);
          });
        },

        put: function (todos) {
          localStorage.setItem(STORAGE_ID, JSON.stringify(todos));
        }
      };
    }]);
})();
