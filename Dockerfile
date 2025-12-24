from tomcat:10.1-jdk17

# remove default apps
run rm -rf /usr/local/tomcat/webapps/*

#Copy war file
copy target/*.war /usr/local/tomcat/webapps/root.war

EXPOSE 8086

cmd ["catalina.sh","run"]