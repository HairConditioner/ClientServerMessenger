package com.github.conditioner.messenger.server

import java.net.DatagramSocket

fun main() {
    val socket = DatagramSocket(8080)
    val server = Server(socket)

    server.receiveAndSend()
}