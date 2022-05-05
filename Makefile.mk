
# VARIABLES
NAME := spring-validation
GIT_COMMIT_HASH := $(shell git log --pretty=format:'%h' -n 1)

BUILD_TOOL := ./mvnw
JAR_FILE := $(shell find target -name '*.jar' 2>/dev/null)
# see https://docs.spring.io/spring-boot/docs/2.0.3.RELEASE/maven-plugin/run-mojo.html#jvmArguments
MEM_OPTS := -Xms128m -Xmx128m -XX:MaxMetaspaceSize=128m
JMX_OPTS := -XX:+UnlockCommercialFeatures -XX:+FlightRecorder -Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.port=39666 -Dcom.sun.management.jmxremote.local.only=false -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false
DEBUG_OPTS := -Xdebug -Xnoagent -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5005
#OTHER_OPTS := -Dspring.profiles.active=

all: clean-build run

# BUILDING
clean-build :		## Clean and Build the application excluding tests
	$(BUILD_TOOL) clean package install -DskipTests

# RUNNING
run :		## Run the application through Spring Boot plugin
	$(BUILD_TOOL) spring-boot:run -DskipTests -Dspring-boot.run.jvmArguments='$(MEM_OPTS) $(JMX_OPTS) $(OTHER_OPTS)'
