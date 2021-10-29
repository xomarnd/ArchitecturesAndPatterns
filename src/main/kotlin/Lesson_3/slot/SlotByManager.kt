package slot

class SlotByManager : Slot {
    override val slot: Slot
        get() = SlotByManager()
}
