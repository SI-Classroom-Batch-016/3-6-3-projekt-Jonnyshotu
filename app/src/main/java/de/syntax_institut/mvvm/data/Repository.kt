package de.syntax_institut.mvvm.data

import de.syntax_institut.mvvm.data.module.Note

class Repository {

    fun loadNotes(): List<Note> {
        return listOf(
            Note(1, "Einkaufen gehen", "Semmeln\nBrezen\nButter\nSchinken", 1),
            Note(2, "Arbeit", "Besprechung um 10 Uhr", 2),
            Note(3, "Geburtstagsgeschenk besorgen", "Kuchen\nGeschenk\nKarte", 3),
            Note(4, "Wichtige Telefonnummer notieren", "0123456789", 1),
            Note(5, "Urlaub planen", "Reiseziel\nHotel\nTransport", 2),
            Note(6, "Sport treiben", "Laufen\nFitnessstudio\nYoga", 1),
            Note(7, "Rechnungen bezahlen", "Miete\nStrom\nWasser", 3),
            Note(8, "Freunde treffen", "Café\nKino\nRestaurant", 2),
            Note(9, "Arzttermin vereinbaren", "Hausarzt\nZahnarzt\nAugenarzt", 1),
            Note(10, "Buch lesen", "Jonas und der Wal", 2),
            Note(11, "TODO", "Auto waschen", 1),
            Note(12, "Gartenarbeit erledigen", "Rasen mähen\nHecke schneiden\nUnkraut jäten", 1),
            Note(13, "Geschenk für Hochzeit kaufen", "Geschenk\nKarte\nVerpackung", 3),
            Note(14, "Lernen für Prüfung", "Kapitel 1\nKapitel 2\nKapitel 3", 2)
        )

    }
}