#!/bin/sh
updatebot push-regex -r "\s+tag: (.*)" -v $(cat VERSION) --previous-line "\s+repository: activiti/ttc-rb-english-campaign" **/values.yaml