package com.example.sub1dicoding.utils

import com.example.sub1dicoding.data.MovieEntity
import com.example.sub1dicoding.data.TvShowsEntity

object DataObject {
    fun listDataMovieDummy() : ArrayList<MovieEntity> {
        val movie = ArrayList<MovieEntity>();

        movie.add(MovieEntity(
            "1",
            "Captain America: The First Avenger",
            "During World War II, Steve Rogers is a sickly man from Brooklyn whos transformed into super-soldier Captain America to aid in the war effort. Rogers must stop the Red Skull – Adolf Hitlers ruthless head of weaponry, and the leader of an organization that intends to use a mysterious device of untold powers for world domination.",
            "Realesed",
            "English",
            "2h 4m",
            "https://image.tmdb.org/t/p/w300_and_h450_bestv2/vSNxAJTlD0r02V9sPYpOjqDZXUK.jpg"
        ))

        movie.add(MovieEntity(
            "2",
            "Avenger",
            "After his own daughter was killed in Panama in 1994, former CIA agent Calvin Dexter became a private 'specialist' in cases which wouldn't reach justice trough the regular legal channels. Two years later he accepts to find Richard 'Ricky' Edmunds for his pa, influential rich businessman Stephen Edmonds. Ricky for a private Canadian war victims charity in Bosnia and went missing. Dexter discovers Ricky was beaten to pulp and drowned for no other crime then helping street boys from the other side by Zoran Zilic and his Serbian paramilitary 'order'. He offers Steven to 'finish the job' as such war criminals don't go to trial. But deputy CIA director Paul Devereaux cares only for a nuclear arms project he wants to use Zilic for. So CIA troubleshooter Frank McBride is ordered to protect him and handle Dexter.",
            "Realesed",
            "English",
            "1h 32m",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/kHQ81KIAq8kD9NfUmHjTgAahoCW.jpg"
        ))

        movie.add(MovieEntity(
            "3",
            "Captain Marvel",
            "The story follows Carol Danvers as she becomes one of the universe’s most powerful heroes when Earth is caught in the middle of a galactic war between two alien races. Set in the 1990s, Captain Marvel is an all-new adventure from a previously unseen period in the history of the Marvel Cinematic Universe.",
            "Realesed",
            "English",
            "2h 4m",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/AtsgWhDnHTq68L0lLsUrCnM7TjG.jpg"
        ))

        movie.add(MovieEntity(
            "4",
            "Marvel One-Shot: Agent Carter",
            "The film takes place one year after the events of Captain America: The First Avenger, in which Agent Carter, a member of the Strategic Scientific Reserve, is in search of the mysterious Zodiac.",
            "Realesed",
            "English",
            "15m",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/liuShDwIUGZegViSIBwQh2zrSef.jpg"
        ))

        movie.add(MovieEntity(
            "5",
            "Marvel One-Shot: The Consultant",
            "Agent Coulson informs Agent Sitwell that the World Security Council wishes Emil Blonsky to be released from prison to join the Avengers Initiative. As Nick Fury doesn't want to release Blonsky, the two agents decide to send a patsy to sabotage the meeting",
            "Realesed",
            "English",
            "15m",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/a9qVEDZBzbjAFqFWBGNmJ9JLLeO.jpg"
        ))

        movie.add(MovieEntity(
            "6",
            "Marvel One-Shot: Item 47",
            "Benny and Claire, a down on their luck couple find a discarded Chitauri gun, referred to as 'Item 47'",
            "Realesed",
            "English",
            "15m",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/rfxvoRoZtBLUXJqLf8z9kgJWkKt.jpg"
        ))

        return movie
    }

    fun listDataTvShowDummy() : ArrayList<TvShowsEntity> {
        val tvshow = ArrayList<TvShowsEntity>();

        tvshow.add(TvShowsEntity(
            "1",
            "Dark",
            "A missing child causes four families to help each other for answers. What they could not imagine is that this mystery would be connected to innumerable other secrets of the small town.",
            "Germain",
            "3",
            "8",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/apbrbWs8M9lyOpJYU5WXrpFbk1Z.jpg"
        ))

        tvshow.add(TvShowsEntity(
            "2",
            "Supernatural",
            "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. ",
            "English",
            "15",
            "20",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/KoYWXbnYuS3b0GyQPkbuexlVK9.jpg"
        ))

        return tvshow
    }
}