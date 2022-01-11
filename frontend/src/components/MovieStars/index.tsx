import {ReactComponent as StarFull} from 'assets/img/estrela.svg';
import {ReactComponent as StarHalf} from 'assets/img/meiaestrela.svg';
import {ReactComponent as StarEmpty} from 'assets/img/estrelavazia.svg';
import "./styles.css";
function MovieStars(){

    return(
        <div className="dsmovie-stars-container">
            <StarFull />
            <StarFull />
            <StarFull />
            <StarHalf />
            <StarEmpty />
        </div>
    );
}
export default MovieStars;