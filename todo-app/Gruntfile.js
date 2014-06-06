module.exports = function(grunt) {
  grunt.loadNpmTasks('grunt-contrib-concat');
  grunt.loadNpmTasks('grunt-contrib-less');
  grunt.loadNpmTasks('grunt-contrib-uglify');
  grunt.loadNpmTasks('grunt-html2js');

  var config = {
    jsSrcDir: 'src/js',
    jsDistDir: 'web-app/js',
    lessSrcDir: 'src/less',
    cssDistDir: 'web-app/css',
    partialsSrcDir: 'src/partials',
    partialsDistDir: 'build/partials'
  }

  grunt.initConfig({
    pkg: config,
    concat: {
      todo: {
        src: ['<%= pkg.jsSrcDir %>/**/*.js', '<%= pkg.partialsDistDir %>/partials.js'],
        dest: '<%= pkg.jsDistDir %>/todo.js'
      }
    },
    html2j: {
      todo: {
        src: ['<%= pkg.partialsSrcDir %>/**/*.html'],
        dest: '<%= pkg.partialsDistDir %>/partials.js',
        options: {
          base: '<%= pkg.partialsSrcDir %>',
          module: 'todo.partials'
        }
      }
    },
    less: {
      todo: {
        options: {
          paths: ['<%= pkg.lessSrcDir %>'],
          yuicompress: false
        },
        files: {
          '<%= pkg.cssDistDir %>/todo.css': ['<%= pkg.lessSrcDir %>/todo.less']
        }
      },
      'todo-min': {
          options: {
            paths: ['<%= pkg.lessSrcDir %>'],
            yuicompress: true
          },
          files: {
            '<%= pkg.cssDistDir %>/todo.css': ['<%= pkg.lessSrcDir %>/todo.less']
          }
      }
    },
    uglify: {
      options: {
        compress: true,
        mangle: {
          except: ['angular', 'jQuery']
        }
      },
      todo: {
        files: {
          '<%= pkg.jsDistDir %>/todo.min.js': ['<%= pkg.jsDistDir %>/todo.js']
        }
      }
    }
  });

  grunt.registerTask('compile', ['html2js', 'concat', 'less:todo', 'less:todo-min', 'uglify']);
}
