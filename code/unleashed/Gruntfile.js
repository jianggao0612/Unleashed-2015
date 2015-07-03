module.exports = function (grunt) {

    var autoprefixer = require('autoprefixer-core');

    grunt.initConfig(
        {
            pkg: grunt.file.readJSON('package.json'),
            "bower-install-simple": {
                options: {
                    color: true,
                    directory: "target/bower"
                },
                "prod": {
                    options: {
                        production: true
                    }
                },
                "dev": {
                    options: {
                        production: false
                    }
                }
            },
            sass: {
                options: {
                    includePaths: ['target/generated-sources/scss'],
                    imagePath: '/images'
                },
                dist: {
                    files: {
                        'target/classes/static/styles/<%= pkg.name %>.css': 'target/generated-sources/scss/<%= pkg.name %>.scss'
                    }
                }
            },
            jshint: {
                files: [
                    'Gruntfile.js',
                        'src/main/js/**/*.js',
                        'src/test/js/**/*.js'
                ],
                options: {
                    globals: {
                        jQuery: true,
                        console: true,
                        module: true,
                        document: true
                    }
                }
            },
            copy: {
                "js-src": {
                    cwd: 'src/main/js',
                    src: '**/*.js',
                    dest: 'target/generated-sources/js',
                    expand: true
                },
                "bootstrap-js": {
                    cwd: 'target/bower/bootstrap/dist/js',
                    src: ['bootstrap.js'],
                    dest: 'target/generated-sources/js/bootstrap',
                    expand: true
                },
                "jquery-js": {
                    cwd: 'target/bower/jquery/dist',
                    src: 'jquery.js',
                    dest: 'target/generated-sources/js/jquery',
                    expand: true
                },
                "d3-js": {
                    cwd: 'target/bower/d3',
                    src: ['d3.js'],
                    dest: 'target/generated-sources/js/d3',
                    expand: true
                },
                "bootstrap-scss": {
                    cwd: 'target/bower/bootstrap-sass/assets/stylesheets',
                    src: ['_bootstrap.scss','bootstrap/**/*.scss'],
                    dest: 'target/generated-sources/scss',
                    expand: true
                },
                "scss-src": {
                    cwd: 'src/main/scss',
                    src: '**/*.scss',
                    dest: 'target/generated-sources/scss',
                    expand: true
                },
                "bootstrap-fonts": {
                    cwd: 'target/bower/bootstrap/fonts',
                    src: ['*.eot', '*.svg', '*.ttf', '*.woff'],
                    dest: 'target/classes/static/fonts/bootstrap',
                    expand: true
                }
            },
            concat: {
                "js": {
                    separator: ';',
                    src: [
                        'target/generated-sources/js/**/*.js',
                        'target/generated-sources/js/jquery/jquery.js',
                        'target/generated-sources/js/bootstrap/bootstrap.js',
                        'target/generated-sources/js/d3/d3.js',
                    ],
                    dest: 'target/classes/static/scripts/<%= pkg.name %>.js'
                },
            },
            uglify: {
                options: {
                    banner: '/*! <%= pkg.name %> <%= grunt.template.today("dd-mm-yyyy") %> */\n'
                },
                dist: {
                    files: {
                        'target/classes/static/scripts/<%= pkg.name %>.min.js': ['target/classes/static/scripts/<%= pkg.name %>.js']
                    }
                }
            },

            postcss: {
                options: {
                    processors: [
                        autoprefixer({ browsers: ['last 2 version']}).postcss
                    ]
                },
                dist: { src: 'target/classes/static/styles/*.css'}
            },
            watch: {
                files: [
                    'Gruntfile.js',
                    'bower.json',
                    'src/main/scss/**/*.scss'
                ],
                tasks: ['default']
            }
        });


    grunt.loadNpmTasks('grunt-bower-install-simple');
    grunt.loadNpmTasks('grunt-sass');
    grunt.loadNpmTasks('grunt-postcss');
    grunt.loadNpmTasks('grunt-contrib-uglify');
    grunt.loadNpmTasks('grunt-contrib-jshint');
    grunt.loadNpmTasks('grunt-contrib-watch');
    grunt.loadNpmTasks('grunt-contrib-copy');
    grunt.loadNpmTasks('grunt-contrib-concat');


    grunt.registerTask('default',
                       ['jshint', 'bower-install-simple', 'copy',
                        'concat', 'uglify', 'sass', 'postcss']);

};
