import React from 'react';
import AliceCarousel from 'react-alice-carousel';
import 'react-alice-carousel/lib/alice-carousel.css';
import { mainCarouselData } from './MainCarouselData';



const MainCarousel = () => {
    const items = mainCarouselData.map(item => <img className='cursor-pointer' src={item.image} role='presentation'></img>)
    return (
        <AliceCarousel
            className='z-10'
                items={items}
                disableButtonsControls
                autoPlay
                autoPlayInterval={2000}
                infinite
        />
    )
};

export default MainCarousel;