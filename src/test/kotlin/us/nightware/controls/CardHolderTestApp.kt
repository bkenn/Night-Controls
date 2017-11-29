package us.nightware.controls

import tornadofx.*

class CardHolderTestApp: App(Main::class) {
    class Main: View() {
        override val root = cardholder {
            card {
                form {
                    fieldset("Test 1") {
                        field("Username") { textfield() }
                        field("Password") { textfield() }
                        field("Phone") { textfield() }
                        field("Email") { textfield() }
                    }
                }
            }
            card {
                form {
                    fieldset("Test 2") {
                        field("Username") { textfield() }
                        field("Password") { textfield() }
                        field("Phone") { textfield() }
                        field("Email") { textfield() }
                    }
                }
            }
        }
    }
}