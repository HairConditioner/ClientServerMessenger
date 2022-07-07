package com.github.conditioner.messenger.server

import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress

class Server(private val socket: DatagramSocket) {

    private val buffer: ByteArray = ByteArray(256)

    fun receiveAndSend() {
        while (true) {
            var packet = DatagramPacket(buffer, buffer.size)

            socket.receive(packet)
            val netAddress: InetAddress = packet.address
            val port: Int = packet.port
            val clientMsg = String(packet.data, 0, packet.length)

            println("Message from client: $clientMsg")
            packet = DatagramPacket(buffer, buffer.size, netAddress, port)
            socket.send(packet)
            break
        }
    }
}