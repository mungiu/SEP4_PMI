FROM jboss/wildfly
ADD ./target/pmi.war /opt/jboss/wildfly/standalone/deployments/