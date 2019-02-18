#!/usr/bin/env python3

# communication entre la machine locale (192.168.0.47) vers raspberry pi
# (192.168.0.19)

# serveur distant programmable avec les commandes suivantes
# - "/play/blink"
# - "/play/raimbow"

# Specification
# A faire
# - "/prog/led/0-150/,r(0-255),g(0-255),b(0-255)"

import socket

HOST = '192.168.0.19'  # The server's hostname or IP address
PORT = 6789        # The port used by the server

with socket.socket(socket.AF_INET, socket.SOCK_DGRAM) as s:
    s.connect((HOST, PORT))
    s.sendall(b"/play/raimbow")
 #   s.sendall(b"/play/blink")
 #   s.sendall(b"/prog/led/33,175,0,75")
    s.close()

exit
