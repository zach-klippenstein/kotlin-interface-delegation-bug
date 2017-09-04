class Implementation(delegate: Interface<Int>) : Interface<Int> by delegate {

  override fun doThing(arg: Int) {
    TODO()
  }
}
