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

        movie.add(MovieEntity(
            "7",
            "Sonic the Hedgehog",
            "Based on the global blockbuster videogame franchise from Sega, Sonic the Hedgehog tells the story of the world’s speediest hedgehog as he embraces his new home on Earth. In this live-action adventure comedy, Sonic and his new best friend team up to defend the planet from the evil genius Dr. Robotnik and his plans for world domination.",
            "Realesed",
            "English",
            "1h 39m",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/aQvJ5WPzZgYVDrxLX4R6cLJCEaQ.jpg"
        ))

        movie.add(MovieEntity(
            "8",
            "Harry Potter and the Philosopher's Stone",
            "Harry Potter has lived under the stairs at his aunt and uncle's house his whole life. But on his 11th birthday, he learns he's a powerful wizard -- with a place waiting for him at the Hogwarts School of Witchcraft and Wizardry. As he learns to harness his newfound powers with the help of the school's kindly headmaster, Harry uncovers the truth about his parents' deaths -- and about the villain who's to blame.",
            "Realesed",
            "English",
            "2h 32m",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/wuMc08IPKEatf9rnMNXvIDxqP4W.jpg"
        ))

        movie.add(MovieEntity(
            "9",
            "Parasite",
            "All unemployed, Ki-taek's family takes peculiar interest in the wealthy and glamorous Parks for their livelihood until they get entangled in an unexpected incident.",
            "Realesed",
            "English",
            "1h 39m",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/7IiTTgloJzvGI1TAYymCfbfl3vT.jpg"
        ))

        movie.add(MovieEntity(
            "10",
            "The Lion King",
            "Simba idolizes his father, King Mufasa, and takes to heart his own royal destiny. But not everyone in the kingdom celebrates the new cub's arrival. Scar, Mufasa's brother—and former heir to the throne—has plans of his own. The battle for Pride Rock is ravaged with betrayal, tragedy and drama, ultimately resulting in Simba's exile. With help from a curious pair of newfound friends, Simba will have to figure out how to grow up and take back what is rightfully his.",
            "Realesed",
            "English",
            "2h 10m",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/dzBtMocZuJbjLOXvrl4zGYigDzh.jpg"
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

        tvshow.add(TvShowsEntity(
            "3",
            "The Simpsons",
            "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
            "English",
            "31",
            "22",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/qcr9bBY6MVeLzriKCmJOv1562uY.jpg"
        ))

        tvshow.add(TvShowsEntity(
            "4",
            "Dragon Ball Z",
            "Five years have passed since the fight with Piccolo Jr., and Goku now has a son, Gohan. The peace is interrupted when an alien named Raditz arrives on Earth in a spacecraft and tracks down Goku, revealing to him that that they are members of a near-extinct warrior race called the Saiyans.",
            "Japanese",
            "38",
            "1995",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/KoYWXbnYuS3b0GyQPkbuexlVK9.jpg"
        ))

        tvshow.add(TvShowsEntity(
            "5",
            "Marvel's Agents of S.H.I.E.L.D.",
            "Agent Phil Coulson of S.H.I.E.L.D. (Strategic Homeland Intervention, Enforcement and Logistics Division) puts together a team of agents to investigate the new, the strange and the unknown around the globe, protecting the ordinary from the extraordinary.",
            "English",
            "7",
            "13",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/gHUCCMy1vvj58tzE3dZqeC9SXus.jpg"
        ))

        tvshow.add(TvShowsEntity(
            "6",
            "NCIS ",
            "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or position.",
            "English",
            "4",
            "10",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/fi8EvaWtL5CvoielOjjVvTr7ux3.jpg"
        ))

        tvshow.add(TvShowsEntity(
            "7",
            "Lucifer",
            "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape. ",
            "English",
            "5",
            "10",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/1sBx2Ew4WFsa1YY32vlHt079O03.jpg"
        ))

        tvshow.add(TvShowsEntity(
            "8",
            "Snowpiercer",
            "Set more than seven years after the world has become a frozen wasteland, the remnants of humanity inhabit a gigantic, perpetually-moving train that circles the globe as class warfare, social injustice and the politics of survival play out.",
            "English",
            "1",
            "10",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/n6UNHZoiYj81abwmG38HbNjflDx.jpg"
        ))

        tvshow.add(TvShowsEntity(
            "9",
            "Doraemon",
            "Doraemon is an anime TV series created by Fujiko F. Fujio and based on the manga series of the same name. This anime is the much more successful successor of the 1973 anime.",
            "Japanese",
            "27",
            "280",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/7QKuHQnj9x0R3damh4FjqQ5pwpc.jpg"
        ))

        tvshow.add(TvShowsEntity(
            "10",
            "Law & Order: Special Victims Unit",
            "In the criminal justice system, sexually-based offenses are considered especially heinous. In New York City, the dedicated detectives who investigate these vicious felonies are members of an elite squad known as the Special Victims Unit. These are their stories.",
            "English",
            "5",
            "22",
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/6t6r1VGQTTQecN4V0sZeqsmdU9g.jpg"
        ))
        return tvshow
    }
}