import React from 'react'
import AddressCard from '../AddressCard/AddressCard'
import OrderTracker from './OrderTracker'
import { Box, Grid } from '@mui/material'
import { deepPurple } from '@mui/material/colors'
import StarBorderIcon from '@mui/icons-material/StarBorder';
const OrderDetails = () => {
  return (
    <div className='px:5 lg:px-20'>
        <div>
            <h1 className='font-bold text-lg py-10'>Delivery Address</h1>
            <AddressCard/>
        </div>
        <div className='py-20'>
            <OrderTracker activeStep={3}/>
        </div>
        <Grid className='space-y-5' container>
            {[1,2,3,4,5].map(item =>
            <Grid item container className='shadow-xl rounded-md p-5 border' 
                
            sx={{alignItems: "center", justifyContent:'space-between'}}>
                <Grid item xs={6}>
                    <div className='flex items-center space-x-4'>
                        <img className='w-[5rem] h-[5rem] object-cover object-top' src="https://i0.wp.com/clover.com.pe/wp-content/uploads/2023/03/SAN-DIEGO-04.webp?fit=700%2C933&ssl=1" alt="" />
                        <div className='space-y-2 ml-5'>
                            <p className='font-semibold'>Men Slim Mid rise Black Jeans</p>
                            <p className='space-x-5 opacity-50 text-xs font-semibold'>
                                <span>Color Pink</span><span>Size: M</span>
                            </p>
                            <p>Seller: Linaria</p>
                            <p>$1999</p>
                        </div>
                    </div>
                </Grid>
                <Grid item>
                    <Box sx={{color: deepPurple[500]}}>
                        <StarBorderIcon sx={{fontSize: "2rem"}} className='px-2 text-5xl'/>
                        <span>Rate & Review Product</span>
                    </Box>
                </Grid>
            </Grid>
            )}
        </Grid>
    </div>
  )
}

export default OrderDetails