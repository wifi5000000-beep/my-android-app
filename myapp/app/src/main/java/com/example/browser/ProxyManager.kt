package com.example.browser

import java.net.Proxy
import java.net.ProxySelector
import java.net.URI

class ProxyManager {
    fun setProxy(ip: String, port: Int) {
        val proxy = Proxy(Proxy.Type.HTTP, java.net.InetSocketAddress(ip, port))
        ProxySelector.setDefault(object : ProxySelector() {
            override fun select(uri: URI): List<Proxy> {
                return listOf(proxy)
            }
            override fun connectFailed(uri: URI, sa: java.net.SocketAddress, ioe: java.io.IOException) {
                // تجاهل الخطأ
            }
        })
    }
}