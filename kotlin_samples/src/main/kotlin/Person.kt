import com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER
import exception.MarriedException
import java.util.logging.ConsoleHandler
import java.util.logging.Level
import java.util.logging.Logger
import java.util.logging.SimpleFormatter

open class Person(val name: String) {
    init {
        val logHandler = ConsoleHandler()
        logHandler.formatter = SimpleFormatter()
        LOGGER.level = Level.INFO
        LOGGER.addHandler(logHandler)

        Logger.getGlobal().useParentHandlers = false
    }

    var isMarried: Boolean = false
    var spouse: Person? = null

    fun marryMe(who: Person) {
        if (isMarried) {
            throw MarriedException("Person ${this.name} is already married")
        }

        LOGGER.info("${this.name} proposed ${who.name}")
        who.sayYes(this)
        this.isMarried = true
        this.spouse = who
        LOGGER.info("Pozdravlyaem ${this.name} and ${who.name}")
    }

    private fun sayYes(whom: Person) {
        this.isMarried = true
        this.spouse = whom
        LOGGER.info("${this.name} say Yes to ${whom.name}")
    }
}