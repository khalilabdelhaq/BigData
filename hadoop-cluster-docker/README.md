## Présentation

Ces contenaires ont été initialement issus de :

- https://github.com/kiwenlau/hadoop-cluster-docker
- https://github.com/liliasfaxi/hadoop-cluster-docker

ouvrir un shell interatctif dans le conteneur master

docker exec -it hadoop-master bash

La première chose à faire, une fois dans le contenaire, est de lancer hadoop et yarn et le metastore Derby (utilisé par Hive). Un script est fourni pour cela, appelé bootstrap.sh. Lancer ce script dans le master node.

./bootstrap.sh

Le numéro de port par défaut pour accéder à Hadoop est 50070. Utilisez l'URL suivante pour obtenir les services Hadoop sur votre navigateur.

http://localhost:50070/

Référence :

https://cwiki.apache.org/confluence/display/hive/hivederbyservermode
