var jvalidate = $("#jvalidate").validate({
                ignore: [],
                rules: {                                            
                        login: {
                                required: true,
                                minlength: 2,
                                maxlength: 8
                        },
                        password: {
                                required: true,
                                minlength: 5,
                                maxlength: 10
                        },
                        're-password': {
                                required: true,
                                minlength: 5,
                                maxlength: 10,
                                equalTo: "#password2"
                        },
                        age: {
                                required: true,
                                min: 18,
                                max: 100
                        },
                        email: {
                                required: true,
                                email: true
                        },
                        date: {
                                required: true,
                                date: true
                        },
                        credit: {
                                required: true,
                                creditcard: true
                        },
                        site: {
                                required: true,
                                url: true
                        }
                    }                                        
                });                                    
