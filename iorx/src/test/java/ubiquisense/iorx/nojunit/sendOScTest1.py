#!/usr/bin/env python3

import socket

HOST = '192.168.0.19'  # The server's hostname or IP address
PORT = 6789        # The port used by the server

with socket.socket(socket.AF_INET, socket.SOCK_DGRAM) as s:
    s.connect((HOST, PORT))
    s.sendall(b"/play/raimbow")
    s.close()

exit