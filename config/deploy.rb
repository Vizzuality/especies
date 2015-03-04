require 'capistrano/ext/multistage'

set :application, "Taxonify"
set :repository,  "git@github.com:unepwcmc/Taxonify.git"
set :branch, "master"
set :scm, "git"
set :scm_username, 'unepwcmc-read'
set :user, "ubuntu"
set(:deploy_to) { File.join("", "home", user, application) }
ssh_options[:forward_agent] = true




namespace :tomcat do
task :deploy do
set :java_home, "/usr/lib/jvm/java-7-openjdk-amd64"
puts "==================Building with Grails======================"
run "export JAVA_HOME=#{java_home} && cd #{deploy_to}/current && /home/ubuntu/.gvm/grails/current/bin/grails prod war Taxonify.war"
puts "========================Delete Old Versions================="
run "sudo rm -rf /var/lib/tomcat7/webapps/Taxonify"
run "sudo rm /var/lib/tomcat7/webapps/Taxonify.war"
puts "========================Copy over New Version================="
run "sudo cp #{deploy_to}/current/Taxonify.war /var/lib/tomcat7/webapps/"
puts "========================Restart Tomcat================="
run "sudo service tomcat7 restart"
end
end
after "deploy", "tomcat:deploy"
