package Lesson_5.slot


class SlotByManager : Slot {
    override val slot: Slot
        get() = SlotByManager()
}