#!/bin/bash

if [ ! $(command -v dsbulk) ]; then
    curl -OL https://downloads.datastax.com/dsbulk/dsbulk-1.8.0.tar.gz

    tar -xvf dsbulk-*.tar.gz

    mv dsbulk* dsbulk
fi


loadFile ()
{
dsbulk load --schema.keyspace "$1" --schema.table "$2" -url "$3" -delim ',' --schema.allowMissingFields true --driver.hosts 3.235.22.55
}

KEYSPACE=covid19
PREFIX=test_

loadFile $KEYSPACE person "${PREFIX}people.csv"
loadFile $KEYSPACE tests "${PREFIX}tests.csv"
loadFile $KEYSPACE tests_kv "${PREFIX}tests_kv.csv"
loadFile $KEYSPACE device "${PREFIX}device.csv"
loadFile $KEYSPACE person_owns_device "${PREFIX}people_device.csv"
loadFile $KEYSPACE device_contact "${PREFIX}device_contact.csv"
