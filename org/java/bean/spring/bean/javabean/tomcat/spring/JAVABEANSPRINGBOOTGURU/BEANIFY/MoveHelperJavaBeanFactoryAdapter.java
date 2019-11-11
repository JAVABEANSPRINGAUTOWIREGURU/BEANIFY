#!/bin/bash
mv -- "$1" "$(dirname "$1")/$(basename "$1" .$2).$3"