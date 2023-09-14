#!/bin/bash

if [[ -z "$HADOOP_HOME" || -z "$DERBY_HOME" ]]; then
    echo "Les variables d'environnement HADOOP_HOME et DERBY_HOME ne sont pas définies correctement."
    exit 1
fi

start_hadoop() {
    echo "Démarrage Hadoop..."
    if ! $HADOOP_HOME/sbin/start-dfs.sh; then
        echo "Erreur lors du démarrage de Hadoop DFS."
        exit 1
    fi

    echo ""

    if ! $HADOOP_HOME/sbin/start-yarn.sh; then
        echo "Erreur lors du démarrage de Hadoop YARN."
        exit 1
    fi

    echo ""
}

start_derby() {
    echo "Démarrage Derby..."
    sed -i 's/NetworkServerControl start/NetworkServerControl start -h 0.0.0.0 -p 49152/' $DERBY_HOME/bin/NetworkServerControl &&
        nohup $DERBY_HOME/bin/startNetworkServer -h 0.0.0.0 -p 49152 &
    if [ $? -ne 0 ]; then
        echo "Erreur lors du démarrage de Derby."
        exit 1
    fi
}

[[ -n $NODE_TYPE ]] && [[ $NODE_TYPE = "m" ]] && start_hadoop
[[ -n $NODE_TYPE ]] && [[ $NODE_TYPE = "m" ]] && start_derby
