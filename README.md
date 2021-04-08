"# kafka-fundamentals" 
# kafka-fundamentals

##HLD
![HLD for Kafka Fundamentals](src/main/resources/static/HLD for kafka Fundamentals.jpg?raw=true "Title")

##CLI commands to start
  ##Windows
    Zookeeper 
        bin\windows\zookeeper-server-start.bat config\zookeeper.properties

    Kafka:
        bin\windows\kafka-server-start.bat config/server.properties

    create topic : 
        kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic my-topic

    producer: 
        bin\windows\kafka-console-producer.bat --topic quickstart-events --bootstrap-server localhost:9092
    consumer : 
        bin\windows\kafka-console-consumer.bat --topic my-topic --bootstrap-server localhost:9092


