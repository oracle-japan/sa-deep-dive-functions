#!/bin/bash

docker run \
    --rm -i grafana/k6 run \
    --out influxdb=http://influxdb.shukawam.me/demo \
    -<not-pc.js