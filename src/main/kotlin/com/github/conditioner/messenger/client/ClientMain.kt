package com.github.conditioner.messenger.client

import java.net.DatagramSocket
import java.net.InetAddress

fun main() {
    val socket = DatagramSocket()
    val netAddress = InetAddress.getByName("localhost")
    val client = Client(socket, netAddress)

    println("> Sending Datagram packets to the server...")
    client.sendAndReceive()
}