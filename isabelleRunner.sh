#!/usr/bin/env bash

/home/isabelle/Isabelle/bin/isabelle process -T $1

if [[ "$?" -lt 2 ]]; then
	exit 0
else
	exit $?
fi
