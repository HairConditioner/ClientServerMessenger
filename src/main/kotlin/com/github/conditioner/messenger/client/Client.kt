package com.github.conditioner.messenger.client

import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress
import java.util.Scanner

class Client(private val socket: DatagramSocket, private val netAddress: InetAddress) {

    private lateinit var buffer: ByteArray

    fun sendAndReceive() {
        val scanner = Scanner(System.`in`)

        while (true) {
            val msgToSend: String = scanner.nextLine()

            buffer = msgToSend.toByteArray()
            val packet = DatagramPacket(buffer, buffer.size, netAddress, 8080)

            socket.send(packet)
            socket.receive(packet)
            val serverMsg = String(packet.data, 0, packet.length)

            println("The server says you said: $serverMsg")
            break
        }
    }
}