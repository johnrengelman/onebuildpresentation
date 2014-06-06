/*global angular */

/**
 * The main TodoMVC app module
 * https://github.com/tastejs/todomvc
 * @type {angular.Module}
 */

//This is a javascript file with its top level require directives
//= require angular/angular.js
//= require angular-route/angular-route.js
//= require_self

(function() {
  angular.module('todomvc', ['ngRoute', 'todo.partials'])
  	.config(function ($routeProvider) {
  		'use strict';

  		$routeProvider.when('/', {
  			controller: 'TodoCtrl',
  			templateUrl: 'todomvc-index.html'
  		}).when('/:status', {
  			controller: 'TodoCtrl',
  			templateUrl: 'todomvc-index.html'
  		}).otherwise({
  			redirectTo: '/'
  		});
  	});
})();
