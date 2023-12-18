#!/bin/bash
amazon-linux-extras install java-openjdk21
javadoc -public -d ./public -sourcepath ./src -subpackages game -subpackages entregable