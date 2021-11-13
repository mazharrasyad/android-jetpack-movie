package com.muhazharrasyad.jetpackmovieiii.utils

import com.muhazharrasyad.jetpackmovieiii.data.source.local.entity.Movie
import com.muhazharrasyad.jetpackmovieiii.data.source.local.entity.MovieEntity
import com.muhazharrasyad.jetpackmovieiii.data.source.local.entity.Tv
import com.muhazharrasyad.jetpackmovieiii.data.source.local.entity.TvEntity
import com.muhazharrasyad.jetpackmovieiii.data.source.remote.response.DataResponse

object DataDummy {

    fun generateMovies(): List<MovieEntity> {

        val movies = ArrayList<MovieEntity>()

        movies.add(
            MovieEntity(
            "m1",
            "https://www.themoviedb.org/t/p/w220_and_h330_face/sKCr78MXSLixwmZ8DyJLrpMsd15.jpg",
            "The Lion King",
            "Feb 11, 2021",
            "83%",
            "A young lion prince is cast out of his pride by his cruel uncle, who claims he killed his father. While the uncle rules with an iron paw, the prince grows up beyond the Savannah, living by a philosophy: No worries for the rest of your days. But when his past comes to haunt him, the young prince must decide his fate: Will he remain an outcast or face his demons and become what he needs to be?"
        )
        )
        movies.add(
            MovieEntity(
            "m2",
            "https://www.themoviedb.org/t/p/w220_and_h330_face/3g8vyePqVatTaUSnrNnrrwguhxM.jpg",
            "WALL·E",
            "Jun 23, 1994",
            "80%",
            "WALL·E is the last robot left on an Earth that has been overrun with garbage and all humans have fled to outer space. For 700 years he has continued to try and clean up the mess, but has developed some rather interesting human-like qualities. When a ship arrives with a sleek new type of robot, WALL·E thinks hes finally found a friend and stows away on the ship when it leaves."
        )
        )
        movies.add(
            MovieEntity(
            "m3",
            "https://www.themoviedb.org/t/p/w220_and_h330_face/cotIVIwA72zGbyJFacCIBXBWssG.jpg",
            "Paperman",
            "Jun 22, 2008",
            "80%",
            "An urban office worker finds that paper airplanes are instrumental in meeting a girl in ways he never expected."
        )
        )
        movies.add(
            MovieEntity(
            "m4",
            "https://www.themoviedb.org/t/p/w220_and_h330_face/5KlRFKKSbyCiyYpZSS3A6G5bW0K.jpg",
            "Akira",
            "Nov 02, 2012",
            "79%",
            "A secret military project endangers Neo-Tokyo when it turns a biker gang member into a rampaging psychic psychopath that only two teenagers and a group of psychics can stop."
        )
        )
        movies.add(
            MovieEntity(
            "m5",
            "https://www.themoviedb.org/t/p/w220_and_h330_face/eAdO0qa9m0NFSVLZ26PvCwmPlsr.jpg",
            "Up",
            "Jul 16, 1988",
            "79%",
            "Carl Fredricksen spent his entire life dreaming of exploring the globe and experiencing life to its fullest. But at age 78, life seems to have passed him by, until a twist of fate (and a persistent 8-year old Wilderness Explorer named Russell) gives him a new lease on life."
        )
        )
        movies.add(
            MovieEntity(
            "m6",
            "https://www.themoviedb.org/t/p/w220_and_h330_face/kPwxXszZDhCShmb82tCjkV15XsV.jpg",
            "The Iron Giant",
            "May 28, 2009",
            "79%",
            "In the small town of Rockwell, Maine in October 1957, a giant metal machine befriends a nine-year-old boy and ultimately finds its humanity by unselfishly saving people from their own fears and prejudices."
        )
        )
        movies.add(
            MovieEntity(
            "m7",
            "https://www.themoviedb.org/t/p/w220_and_h330_face/6hAgSxgd2YIK5pYhwowtnlGpwbe.jpg",
            "Feast",
            "Aug 06, 1999",
            "79%",
            "This Oscar-winning animated short film tells the story of one mans love life as seen through the eyes of his best friend and dog, Winston, and revealed bite by bite through the meals they share."
        )
        )
        movies.add(
            MovieEntity(
            "m8",
            "https://www.themoviedb.org/t/p/w220_and_h330_face/hCaUWmS7GyQAyfNfsJdZyZrEc5U.jpg",
            "La luna",
            "Oct 25, 2014",
            "79%",
            "A young boy comes of age in the most peculiar of circumstances. Tonight is the very first time his Papa and Grandpa are taking him to work. In an old wooden boat they row far out to sea, and with no land in sight, they stop and wait. A big surprise awaits the boy as he discovers his familys most unusual line of work. Should he follow the example of his Papa, or his Grandpa? Will he be able to find his own way in the midst of their conflicting opinions and timeworn traditions?"
        )
        )
        movies.add(
            MovieEntity(
            "m9",
            "https://www.themoviedb.org/t/p/w220_and_h330_face/pHHWwdv77IUlyGlfEZxkB3yJcij.jpg",
            "Partly Cloudy",
            "Feb 10, 2012",
            "79%",
            "Everyone knows that the stork delivers babies, but where do the storks get the babies from? The answer lies up in the stratosphere, where cloud people sculpt babies from clouds and bring them to life. Gus, a lonely and insecure grey cloud, is a master at creating \"dangerous\" babies. Crocodiles, porcupines, rams and more - Guss beloved creations are works of art, but more than a handful for his loyal delivery stork partner, Peck. As Guss creations become more and more rambunctious, Pecks job gets harder and harder. How will Peck manage to handle both his hazardous cargo and his friends fiery temperament?"
        )
        )
        movies.add(
            MovieEntity(
            "m10",
            "https://www.themoviedb.org/t/p/w220_and_h330_face/eHuGQ10FUzK1mdOY69wF5pGgEf5.jpg",
            "Finding Nemo",
            "May 30, 2003",
            "78%",
            "Nemo, an adventurous young clownfish, is unexpectedly taken from his Great Barrier Reef home to a dentists office aquarium. Its up to his worrisome father Marlin and a friendly but forgetful fish Dory to bring Nemo home — meeting vegetarian sharks, surfer dude turtles, hypnotic jellyfish, hungry seagulls, and more along the way."
        )
        )
        return movies
    }

    fun generateTvs(): List<TvEntity> {

        val tvs = ArrayList<TvEntity>()

        tvs.add(
            TvEntity(
            "t1",
            "https://www.themoviedb.org/t/p/w220_and_h330_face/ss4AocYgqZ06aSBiw1DWlSi9qz2.jpg",
            "Franky Snow",
            "Jan 01, 2007",
            "100%",
            "We dont have an overview translated in English. Help us expand our database by adding one."
        )
        )
        tvs.add(
            TvEntity(
            "t2",
            "https://www.themoviedb.org/t/p/w220_and_h330_face/emhR1R4RoInbTkJjzFbBaQW9Hn7.jpg",
            "Love in a second world",
            "May 03, 2021",
            "100%",
            "We dont have an overview translated in English. Help us expand our database by adding one."
        )
        )
        tvs.add(
            TvEntity(
            "t3",
            "https://www.themoviedb.org/t/p/w220_and_h330_face/6O5HRRTk8hykC1lO3mBKUyG0Dc1.jpg",
            "Hasya Katta Official",
            "Aug 14, 2020",
            "100%",
            "Hasya Katta Official a youtube show by Smit Shetye"
        )
        )
        tvs.add(
            TvEntity(
            "t4",
            "https://www.themoviedb.org/t/p/w220_and_h330_face/uURwwsf4E56FNp5AwHC8sKQrEiV.jpg",
            "Mighty Express",
            "Sep 22, 2020",
            "100%",
            "Catch a ride with the Mighty Express — a team of trains and their kid friends who overcome trouble on the tracks with quick thinking and teamwork!"
        )
        )
        tvs.add(
            TvEntity(
            "t5",
            "https://www.themoviedb.org/t/p/w220_and_h330_face/5XfvHjDxa6GMVgeeVbQZu92HbMy.jpg",
            "Master of Task",
            "Aug 03, 2020",
            "100%",
            "We dont have an overview translated in English. Help us expand our database by adding one."
        )
        )
        tvs.add(
            TvEntity(
            "t6",
            "https://www.themoviedb.org/t/p/w220_and_h330_face/uhQY8ppUgpYIC0LwtJjuA1REZzN.jpg",
            "Buddi",
            "Mar 20, 2020",
            "100%",
            "The Buddis bounce, spin, glide — and giggle! — through their magical world, learning new things and sharing the joy of friendship."
        )
        )
        tvs.add(
            TvEntity(
            "t7",
            "https://www.themoviedb.org/t/p/w220_and_h330_face/uNk9ygic7W4tuIWoYqyocDLFibf.jpg",
            "Dr. Panda TotoTime",
            "Nov 03, 2017",
            "100%",
            "The adventures of Dr. Panda and Toto as they go on awesome adventures in Panda City. They discover the world together with their friends Bip, Olette, Meimei, Hoopa, Moo, Richy &amp; June and solve puzzles, learn about shapes, colors, numbers and more."
        )
        )
        tvs.add(
            TvEntity(
            "t8",
            "https://www.themoviedb.org/t/p/w220_and_h330_face/1KhwbhsKXXbYHMPncID0alOS6gk.jpg",
            "Loup",
            "Jan 01, 2019",
            "100%",
            "We dont have an overview translated in English. Help us expand our database by adding one."
        )
        )
        tvs.add(
            TvEntity(
            "t9",
            "https://www.themoviedb.org/t/p/w220_and_h330_face/eMLVOOPY2l6yWKRgC0yFew4xYXZ.jpg",
            "Angry Birds Blues",
            "Mar 10, 2017",
            "100%",
            "Angry Birds Blues is a Finnish computer-animated television series starring the Blues (Jay, Jake and Jim) and the Hatchlings that appeared in The Angry Birds Movie. Animated in the same style as the movie, it was produced by Rovio Entertainment along with its affiliated company Kaiken Entertainment, with Bardel Entertainment providing its animation. The series premiered on 10 March 2017 on the Toons.TV channel, before continuing on the Angry Birds official YouTube channel after ToonsTV was shut down."
        )
        )
        tvs.add(
            TvEntity(
            "t10",
            "https://www.themoviedb.org/t/p/w220_and_h330_face/3a3UPopPpqHzJA7iVpIjejSOMcO.jpg",
            "Counterfeit Cat",
            "May 12, 2016",
            "100%",
            "Gark is not a real cat. He’s a Counterfeit Cat. He’s a small blue alien in a purple cat costume. Max is a real cat: fat, fluffy, yellow and constantly pampered by his doting owner Betty. When Gark crashes his spaceship into Betty’s laundry room, he finds a new home and forms an unconventional friendship with Max, who quickly learns how to take advantage of Gark’s mysterious alien powers and his sweet, trusting nature. Max loves having an admirer who will do anything for him, but Gark’s extreme curiosity and lack of understanding about life on Earth push Max out of his comfort zone and into ridiculous hair-raising adventures. Whether they are just hanging out at home or zipping through space and exploring new planets, Gark’s adventurous instincts will force Max to become the hero Gark believes him to be."
        )
        )

        return tvs
    }

    fun generateRemoteMovies(): List<DataResponse> {

        val movies = ArrayList<DataResponse>()

        movies.add(
            DataResponse(
                "m1",
                "https://www.themoviedb.org/t/p/w220_and_h330_face/sKCr78MXSLixwmZ8DyJLrpMsd15.jpg",
                "The Lion King",
                "Feb 11, 2021",
                "83%",
                "A young lion prince is cast out of his pride by his cruel uncle, who claims he killed his father. While the uncle rules with an iron paw, the prince grows up beyond the Savannah, living by a philosophy: No worries for the rest of your days. But when his past comes to haunt him, the young prince must decide his fate: Will he remain an outcast or face his demons and become what he needs to be?"
            )
        )
        movies.add(
            DataResponse(
                "m2",
                "https://www.themoviedb.org/t/p/w220_and_h330_face/3g8vyePqVatTaUSnrNnrrwguhxM.jpg",
                "WALL·E",
                "Jun 23, 1994",
                "80%",
                "WALL·E is the last robot left on an Earth that has been overrun with garbage and all humans have fled to outer space. For 700 years he has continued to try and clean up the mess, but has developed some rather interesting human-like qualities. When a ship arrives with a sleek new type of robot, WALL·E thinks hes finally found a friend and stows away on the ship when it leaves."
            )
        )
        movies.add(
            DataResponse(
                "m3",
                "https://www.themoviedb.org/t/p/w220_and_h330_face/cotIVIwA72zGbyJFacCIBXBWssG.jpg",
                "Paperman",
                "Jun 22, 2008",
                "80%",
                "An urban office worker finds that paper airplanes are instrumental in meeting a girl in ways he never expected."
            )
        )
        movies.add(
            DataResponse(
                "m4",
                "https://www.themoviedb.org/t/p/w220_and_h330_face/5KlRFKKSbyCiyYpZSS3A6G5bW0K.jpg",
                "Akira",
                "Nov 02, 2012",
                "79%",
                "A secret military project endangers Neo-Tokyo when it turns a biker gang member into a rampaging psychic psychopath that only two teenagers and a group of psychics can stop."
            )
        )
        movies.add(
            DataResponse(
                "m5",
                "https://www.themoviedb.org/t/p/w220_and_h330_face/eAdO0qa9m0NFSVLZ26PvCwmPlsr.jpg",
                "Up",
                "Jul 16, 1988",
                "79%",
                "Carl Fredricksen spent his entire life dreaming of exploring the globe and experiencing life to its fullest. But at age 78, life seems to have passed him by, until a twist of fate (and a persistent 8-year old Wilderness Explorer named Russell) gives him a new lease on life."
            )
        )
        movies.add(
            DataResponse(
                "m6",
                "https://www.themoviedb.org/t/p/w220_and_h330_face/kPwxXszZDhCShmb82tCjkV15XsV.jpg",
                "The Iron Giant",
                "May 28, 2009",
                "79%",
                "In the small town of Rockwell, Maine in October 1957, a giant metal machine befriends a nine-year-old boy and ultimately finds its humanity by unselfishly saving people from their own fears and prejudices."
            )
        )
        movies.add(
            DataResponse(
                "m7",
                "https://www.themoviedb.org/t/p/w220_and_h330_face/6hAgSxgd2YIK5pYhwowtnlGpwbe.jpg",
                "Feast",
                "Aug 06, 1999",
                "79%",
                "This Oscar-winning animated short film tells the story of one mans love life as seen through the eyes of his best friend and dog, Winston, and revealed bite by bite through the meals they share."
            )
        )
        movies.add(
            DataResponse(
                "m8",
                "https://www.themoviedb.org/t/p/w220_and_h330_face/hCaUWmS7GyQAyfNfsJdZyZrEc5U.jpg",
                "La luna",
                "Oct 25, 2014",
                "79%",
                "A young boy comes of age in the most peculiar of circumstances. Tonight is the very first time his Papa and Grandpa are taking him to work. In an old wooden boat they row far out to sea, and with no land in sight, they stop and wait. A big surprise awaits the boy as he discovers his familys most unusual line of work. Should he follow the example of his Papa, or his Grandpa? Will he be able to find his own way in the midst of their conflicting opinions and timeworn traditions?"
            )
        )
        movies.add(
            DataResponse(
                "m9",
                "https://www.themoviedb.org/t/p/w220_and_h330_face/pHHWwdv77IUlyGlfEZxkB3yJcij.jpg",
                "Partly Cloudy",
                "Feb 10, 2012",
                "79%",
                "Everyone knows that the stork delivers babies, but where do the storks get the babies from? The answer lies up in the stratosphere, where cloud people sculpt babies from clouds and bring them to life. Gus, a lonely and insecure grey cloud, is a master at creating \"dangerous\" babies. Crocodiles, porcupines, rams and more - Guss beloved creations are works of art, but more than a handful for his loyal delivery stork partner, Peck. As Guss creations become more and more rambunctious, Pecks job gets harder and harder. How will Peck manage to handle both his hazardous cargo and his friends fiery temperament?"
            )
        )
        movies.add(
            DataResponse(
                "m10",
                "https://www.themoviedb.org/t/p/w220_and_h330_face/eHuGQ10FUzK1mdOY69wF5pGgEf5.jpg",
                "Finding Nemo",
                "May 30, 2003",
                "78%",
                "Nemo, an adventurous young clownfish, is unexpectedly taken from his Great Barrier Reef home to a dentists office aquarium. Its up to his worrisome father Marlin and a friendly but forgetful fish Dory to bring Nemo home — meeting vegetarian sharks, surfer dude turtles, hypnotic jellyfish, hungry seagulls, and more along the way."
            )
        )
        return movies
    }

    fun generateRemoteTvs(): List<DataResponse> {

        val tvs = ArrayList<DataResponse>()

        tvs.add(
            DataResponse(
                "t1",
                "https://www.themoviedb.org/t/p/w220_and_h330_face/ss4AocYgqZ06aSBiw1DWlSi9qz2.jpg",
                "Franky Snow",
                "Jan 01, 2007",
                "100%",
                "We dont have an overview translated in English. Help us expand our database by adding one."
            )
        )
        tvs.add(
            DataResponse(
                "t2",
                "https://www.themoviedb.org/t/p/w220_and_h330_face/emhR1R4RoInbTkJjzFbBaQW9Hn7.jpg",
                "Love in a second world",
                "May 03, 2021",
                "100%",
                "We dont have an overview translated in English. Help us expand our database by adding one."
            )
        )
        tvs.add(
            DataResponse(
                "t3",
                "https://www.themoviedb.org/t/p/w220_and_h330_face/6O5HRRTk8hykC1lO3mBKUyG0Dc1.jpg",
                "Hasya Katta Official",
                "Aug 14, 2020",
                "100%",
                "Hasya Katta Official a youtube show by Smit Shetye"
            )
        )
        tvs.add(
            DataResponse(
                "t4",
                "https://www.themoviedb.org/t/p/w220_and_h330_face/uURwwsf4E56FNp5AwHC8sKQrEiV.jpg",
                "Mighty Express",
                "Sep 22, 2020",
                "100%",
                "Catch a ride with the Mighty Express — a team of trains and their kid friends who overcome trouble on the tracks with quick thinking and teamwork!"
            )
        )
        tvs.add(
            DataResponse(
                "t5",
                "https://www.themoviedb.org/t/p/w220_and_h330_face/5XfvHjDxa6GMVgeeVbQZu92HbMy.jpg",
                "Master of Task",
                "Aug 03, 2020",
                "100%",
                "We dont have an overview translated in English. Help us expand our database by adding one."
            )
        )
        tvs.add(
            DataResponse(
                "t6",
                "https://www.themoviedb.org/t/p/w220_and_h330_face/uhQY8ppUgpYIC0LwtJjuA1REZzN.jpg",
                "Buddi",
                "Mar 20, 2020",
                "100%",
                "The Buddis bounce, spin, glide — and giggle! — through their magical world, learning new things and sharing the joy of friendship."
            )
        )
        tvs.add(
            DataResponse(
                "t7",
                "https://www.themoviedb.org/t/p/w220_and_h330_face/uNk9ygic7W4tuIWoYqyocDLFibf.jpg",
                "Dr. Panda TotoTime",
                "Nov 03, 2017",
                "100%",
                "The adventures of Dr. Panda and Toto as they go on awesome adventures in Panda City. They discover the world together with their friends Bip, Olette, Meimei, Hoopa, Moo, Richy &amp; June and solve puzzles, learn about shapes, colors, numbers and more."
            )
        )
        tvs.add(
            DataResponse(
                "t8",
                "https://www.themoviedb.org/t/p/w220_and_h330_face/1KhwbhsKXXbYHMPncID0alOS6gk.jpg",
                "Loup",
                "Jan 01, 2019",
                "100%",
                "We dont have an overview translated in English. Help us expand our database by adding one."
            )
        )
        tvs.add(
            DataResponse(
                "t9",
                "https://www.themoviedb.org/t/p/w220_and_h330_face/eMLVOOPY2l6yWKRgC0yFew4xYXZ.jpg",
                "Angry Birds Blues",
                "Mar 10, 2017",
                "100%",
                "Angry Birds Blues is a Finnish computer-animated television series starring the Blues (Jay, Jake and Jim) and the Hatchlings that appeared in The Angry Birds Movie. Animated in the same style as the movie, it was produced by Rovio Entertainment along with its affiliated company Kaiken Entertainment, with Bardel Entertainment providing its animation. The series premiered on 10 March 2017 on the Toons.TV channel, before continuing on the Angry Birds official YouTube channel after ToonsTV was shut down."
            )
        )
        tvs.add(
            DataResponse(
                "t10",
                "https://www.themoviedb.org/t/p/w220_and_h330_face/3a3UPopPpqHzJA7iVpIjejSOMcO.jpg",
                "Counterfeit Cat",
                "May 12, 2016",
                "100%",
                "Gark is not a real cat. He’s a Counterfeit Cat. He’s a small blue alien in a purple cat costume. Max is a real cat: fat, fluffy, yellow and constantly pampered by his doting owner Betty. When Gark crashes his spaceship into Betty’s laundry room, he finds a new home and forms an unconventional friendship with Max, who quickly learns how to take advantage of Gark’s mysterious alien powers and his sweet, trusting nature. Max loves having an admirer who will do anything for him, but Gark’s extreme curiosity and lack of understanding about life on Earth push Max out of his comfort zone and into ridiculous hair-raising adventures. Whether they are just hanging out at home or zipping through space and exploring new planets, Gark’s adventurous instincts will force Max to become the hero Gark believes him to be."
            )
        )

        return tvs
    }

    fun generateMovieDetail(movie: MovieEntity, favorited: Boolean): Movie {
        movie.favorited = favorited
        return Movie(movie)
    }

    fun generateTvDetail(tv: TvEntity, favorited: Boolean): Tv {
        tv.favorited = favorited
        return Tv(tv)
    }
}