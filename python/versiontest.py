#!/usr/bin/env python

import sys

__all__ = ['minimalPythonVersion']


def minimalPythonVersion(major,minor,micro):
    "Checks current version of Python interpreter. Returns true if minimal version."
    currentVersion = (sys.version_info.major,sys.version_info.minor,sys.version_info.micro)
    return (currentVersion >= (major,minor,micro))

