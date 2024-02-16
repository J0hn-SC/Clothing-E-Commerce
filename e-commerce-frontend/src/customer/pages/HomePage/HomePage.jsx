import React from 'react'
import MainCarousel from '../../components/HomeCarousel/MainCarousel'
import HomeSectionCarousel from '../../components/HomeSectionCarousel/HomeSectionCarousel'
import { mens_data } from '../../../data/mens'
import HomeSectionCard from '../../components/HomeSectionCard/HomeSectionCard'

const HomePage = () => {
  const mens_data_items = mens_data.slice(0,20).map((item) => <HomeSectionCard product = {item}/>)
  return (
    <div>
        <MainCarousel></MainCarousel>
        <div className='space-y-10 py-20 flex flex-col justify-center px-5 lg:px-10'>
            <HomeSectionCarousel sectionName={"Mens"} data={mens_data_items}/>
            <HomeSectionCarousel sectionName={"Mens Shirt"} data={mens_data_items}/>
            <HomeSectionCarousel sectionName={"Mens Shoes"} data={mens_data_items}/>
            <HomeSectionCarousel sectionName={"Women"} data={mens_data_items}/>
        </div>
    </div>
  )
}

export default HomePage