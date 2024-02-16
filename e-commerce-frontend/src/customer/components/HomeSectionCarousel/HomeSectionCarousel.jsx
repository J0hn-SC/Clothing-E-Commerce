import React, { memo, useState } from 'react'
import HomeSectionCard from '../HomeSectionCard/HomeSectionCard'
import AliceCarousel from 'react-alice-carousel'
import {Button} from "@mui/material"
import KeyboardArrowLeftIcon from '@mui/icons-material/KeyboardArrowLeft';
import KeyboardArrowRightIcon from '@mui/icons-material/KeyboardArrowRight';
import { mens_data } from '../../../data/mens';

const responsive =  {
    0: {items: 1},
    720: {items: 2},
    1024: {items: 5.5},
};
//const items = mens_data.slice(0,20).map(item => <HomeSectionCard product={item}/>)
const HomeSectionCarousel = ({data, sectionName}) => {
    const [activeIndex, setActiveIndex] = useState(0);
    
    const slidePrev = () => {
        setActiveIndex(activeIndex - 1);
    }
    const slideNext = () => {
        setActiveIndex(activeIndex + 1);
    }
    const syncActiveIndex = ({item}) => {
        setActiveIndex(item);
        console.log("sync: ", activeIndex)
    }
  return (
    <div className=''>
        <h2 className='text-2xl font-extrabold text-gray-800 py-5'>{sectionName}</h2>
        <div className='relative p-5'>
            <AliceCarousel
                items={data}
                disableDotsControls
                disableButtonsControls
                responsive={responsive}
                onSlideChanged={syncActiveIndex}
                activeIndex={activeIndex}
            />
            { activeIndex > 0 &&
                <Button variant='contained' className='z-50 bg-white' onClick={slidePrev}
            sx={{position: 'absolute', top:'8rem', 
            left: "0rem", transform: "", bgcolor: "white"}} aria-label='next'>
                <KeyboardArrowLeftIcon sx={{color: "black"}}/>
            </Button>
            }

            {activeIndex < data.length - 5 &&
                <Button variant='contained' className='z-50 bg-white' onClick={slideNext}
            sx={{position: 'absolute', top:'8rem', 
            right: "0rem", transform: "", bgcolor: "white"}} aria-label='next'>
                <KeyboardArrowRightIcon sx={{color: "black"}}/>
            </Button>
            }
        </div>
    </div>
  )
};

export default HomeSectionCarousel