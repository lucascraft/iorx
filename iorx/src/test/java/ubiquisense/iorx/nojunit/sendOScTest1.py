#!/usr/bin/env python3

import socket

<<<<<<< HEAD
HOST = '192.168.0.19'  # The server's hostname or IP address
=======
HOST = '127.0.0.1'  # The server's hostname or IP address
>>>>>>> branch 'master' of https://github.com/lucascraft/iorx.git
PORT = 6789        # The port used by the server

with socket.socket(socket.AF_INET, socket.SOCK_DGRAM) as s:
    s.connect((HOST, PORT))
<<<<<<< HEAD
    s.sendall(b"/play/raimbow")
    s.close()

exit
=======
    s.sendall(b"/play/raimbow")
>>>>>>> branch 'master' of https://github.com/lucascraft/iorx.git
