set :rails_env, "staging"
# Primary domain name of your application. Used in the Apache configs

role :web, "ec2-54-94-97-96.sa-east-1.compute.amazonaws.com" # Your HTTP server, Apache/etc
role :app, "ec2-54-94-97-96.sa-east-1.compute.amazonaws.com" # This may be the same as your `Web` server
role :db, "ec2-54-94-97-96.sa-east-1.compute.amazonaws.com", :primary => true # This is where Rails migrations wil
