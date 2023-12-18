#!/bin/bash
amazon-linux-extras install java-openjdk21
rm -rf ./src/entregable/adicional/
javadoc -public -d ./public -sourcepath ./src -subpackages game -subpackages entregable