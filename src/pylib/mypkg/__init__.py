# -*- coding: utf-8 -*-
"""
Created on Thu Feb 25 16:35:01 2021

@author: tjoeun
"""
try:
    import os
    import _mypkg_foo
    __path__.append(os.path.abspath(os.path.dirname(_mypkg_foo.__file__)))
    
except ImportError:
    print("_mypkg_foo import error")
