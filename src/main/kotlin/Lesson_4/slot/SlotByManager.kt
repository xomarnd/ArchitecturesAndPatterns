package Lesson_4.slot

class SlotByManager : Slot {
    override val slot: Slot
        get() = SlotByManager()
}