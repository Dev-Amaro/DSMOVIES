import axios from "axios";
import MovieCard from "components/MovieCard";
import Paginations from "components/paginations";
import { BASE_URL } from "utils/request";

function Listing() {

    // FORMA ERRADA
    axios.get(`${BASE_URL}/movies?size=12&page=0`)
        .then(response => {
            console.log(response.data);
        });

    return (
        <>
            <Paginations />

            <div className="container">
                <div className="row">
                    <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                        <MovieCard />
                    </div>
                    <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                        <MovieCard />
                    </div>
                    <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                        <MovieCard />
                    </div>
                    <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                        <MovieCard />
                    </div>
                    <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                        <MovieCard />
                    </div>
                </div>
            </div>




        </>

    );
}
export default Listing;