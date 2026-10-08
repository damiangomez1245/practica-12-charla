package mx.tec.charla.domain

import org.junit.Assert
import org.junit.Test

class EnlaceTest {

    @Test
    fun la_direccion_sola_queda_igual() {
        Assert.assertEquals(
            "https://abc.trycloudflare.com",
            Enlace.servidorDesde("https://abc.trycloudflare.com")
        )
    }

    @Test
    fun se_quitan_la_diagonal_final_y_la_ruta() {
        Assert.assertEquals(
            "https://abc.trycloudflare.com",
            Enlace.servidorDesde("https://abc.trycloudflare.com/")
        )
        Assert.assertEquals(
            "https://abc.trycloudflare.com",
            Enlace.servidorDesde("https://abc.trycloudflare.com/chat")
        )
    }

    @Test
    fun se_encuentra_dentro_de_un_mensaje_compartido() {
        Assert.assertEquals(
            "https://abc.trycloudflare.com",
            Enlace.servidorDesde("Entra a mi sala de Charla: https://abc.trycloudflare.com")
        )
    }

    @Test
    fun el_puerto_se_conserva() {
        Assert.assertEquals("http://10.0.2.2:8000", Enlace.servidorDesde("http://10.0.2.2:8000"))
    }

    @Test
    fun lo_que_no_es_un_enlace_es_null() {
        Assert.assertNull(Enlace.servidorDesde("hola"))
        Assert.assertNull(Enlace.servidorDesde("ftp://abc.com"))
        Assert.assertNull(Enlace.servidorDesde(""))
    }
}